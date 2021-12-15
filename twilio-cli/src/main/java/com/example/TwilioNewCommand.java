package com.example;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.inject.Inject;
import lombok.SneakyThrows;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "new", mixinStandardHelpOptions = true)
public class TwilioNewCommand implements Runnable {

    @Parameters(paramLabel = "<number>", defaultValue = "+18442939037")
    String toNumber;

    @Parameters(paramLabel = "twiml")
    String twiml;

    @Inject
    Config config;


    @SneakyThrows
    @Override
    public void run() {
        Twilio.init(config.accountSid(), config.authToken());

        final PhoneNumber to = new PhoneNumber(toNumber);
        final PhoneNumber from = new PhoneNumber(config.phoneNumber());
        Call call = Call.creator(
                to,
                from,
                new com.twilio.type.Twiml(Files.readString(Path.of(twiml))))
            .create();
        System.out.println(call.getSid());
    }

}

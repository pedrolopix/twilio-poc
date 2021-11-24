package com.example;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.inject.Inject;
import lombok.SneakyThrows;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "update", mixinStandardHelpOptions = true)
public class TwilioUpdateCommand implements Runnable {

    @Parameters(paramLabel = "sid")
    String sid;

    @Parameters(paramLabel = "twiml")
    String twiml;

    @Inject
    Config config;

    @SneakyThrows
    @Override
    public void run() {
        Twilio.init(config.accountSid(), config.authToken());

        Call call = Call.updater(sid)
            .setTwiml(
                new com.twilio.type.Twiml(Files.readString(Path.of(twiml))))
            .update();

        System.out.println(call.getSid());
    }

}

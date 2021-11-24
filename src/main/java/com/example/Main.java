package com.example;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = {TwilioNewCommand.class, TwilioUpdateCommand.class})
public class Main {
}

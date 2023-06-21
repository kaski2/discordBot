import commands.Calculator;
import events.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class discordBot {

    public static void main(String[] args) throws LoginException {
        JDA bot = null;
        try {

            Scanner scanner = new Scanner(new File("src/main/java/token.txt"));
            String token = scanner.nextLine();
            scanner.close();
            bot = JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES)
                    .setActivity(Activity.playing("intelliJ"))
                    .build();


        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
            System.exit(-1);
        }

        bot.updateCommands().addCommands(
                // these are not required?? figure out how to make them mandatory
                Commands.slash("calculate", "Does a simple calculation for you.")
                        .addOption(OptionType.INTEGER, "number", "The first number")
                        .addOption(OptionType.STRING, "operator", "choose what operation you want: +, -")
                        .addOption(OptionType.INTEGER, "number2", "Second number")
        ).queue();
        bot.addEventListener(new HelloEvent());
        bot.addEventListener(new Calculator());


    }
}

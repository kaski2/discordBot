import events.helloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class discordBot {

    public static void main(String[] args) throws LoginException {
        String token;
        try{

            Scanner scanner = new Scanner(new File("src/main/java/token.txt"));
            token = scanner.nextLine();
            scanner.close();
            JDA bot = JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES)
                    .setActivity(Activity.playing("intelliJ"))
                    .build();

            bot.addEventListener(new helloEvent());
        }catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }

    }
}

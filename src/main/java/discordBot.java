import events.helloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class discordBot {

    public static void main(String[] args) throws LoginException {

        JDA bot = JDABuilder.createLight("MTEyMTAzMDcyOTg4MzcxMzU0Nw.GnHhcK.AWwa0cVibpOV-yst9M_JZa2PK6sDJ3EJbubra8", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.GUILD_MESSAGES)
                .setActivity(Activity.playing("intelliJ"))
                .build();

        bot.addEventListener(new helloEvent());
    }
}

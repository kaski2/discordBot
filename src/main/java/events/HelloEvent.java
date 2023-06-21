package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class HelloEvent extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String userName = Objects.requireNonNull(event.getMember()).getUser().getEffectiveName();
        for(String i : messageSent){
            if(Objects.requireNonNull(event.getMember()).getUser().isBot()){
                break;
            }
            if(i.equalsIgnoreCase("hello")){
                event.getChannel().sendMessage("very funny, " + userName).queue();
                break;
            }
        }

    }
}

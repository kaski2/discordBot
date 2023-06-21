package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.*;

public class Calculator extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event){
        List<String> msg;
        msg = new ArrayList<>(Arrays.asList(event.getMessage().getContentRaw().split(" ")));




        if(msg.get(0).equalsIgnoreCase("!calculate")){
            //event.getChannel().sendMessage("calculating command").queue();
            try{
                int num1 = Integer.parseInt(msg.get(2));
                int num2 = Integer.parseInt(msg.get(4));
            }catch(NumberFormatException e){
                event.getChannel().sendMessage("Not a number!").queue();
            }
            String operation = msg.get(3);
        }
    }
}

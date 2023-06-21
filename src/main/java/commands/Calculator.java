package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
//import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
//import java.util.*;

public class Calculator extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        //List<String> msg;
        //msg = new ArrayList<>(Arrays.asList(event.getMessage().getContentRaw().split(" ")));
        int num1;
        int num2;
        /*
        if(msg.size() == 1){
            event.getChannel().sendMessage("Usage: !calculate <num> <+ or -> <num2>").queue();
            return;
        }*/

        if(event.getName().equals("calculate")){
            event.deferReply().queue();

            try{
                num1 = event.getOption("number").getAsInt();
                num2 = event.getOption("number2").getAsInt();
            }catch(NumberFormatException e){
                event.getChannel().sendMessage("Not a number!").queue();
                return;
            }

            String operation = event.getOption("operator").getAsString();
            if(operation.equals("+")){
                event.getHook().sendMessage(num1 + " + " + num2 + " = " + (num1 + num2)).queue();
            }else if(operation.equals("-")){
                event.getHook().sendMessage(num1 + " - " + num2 + " = " + (num1 - num2)).queue();
            }
        }


    }
}

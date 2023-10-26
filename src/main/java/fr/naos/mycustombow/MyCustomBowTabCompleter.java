package fr.naos.mycustombow;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class MyCustomBowTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> completions = new java.util.ArrayList<>();
        if (strings.length == 1) {
            completions.add("give");
        } else if (strings.length == 3) {
            completions.add("fireball");
            completions.add("lightning");
            completions.add("tnt");
            completions.add("switch");
            completions.add("gravity");
            completions.add("snowball");
            completions.add("teleport");
        }
        return completions;
    }
}

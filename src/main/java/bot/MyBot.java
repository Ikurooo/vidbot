package bot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyBot extends ListenerAdapter {

    private static final YoutubeLinkScraper scraper = new YoutubeLinkScraper();

    public static void main(String[] args) throws Exception {
        JDABuilder builder = JDABuilder.createDefault("MTIwNTg1NzQxNDc3NjIyNTg0Mg.GjRJGc.oE6cuy9aZJFDxLOfBkb5jJnGong2txobLR7Wr8");
        builder.addEventListeners(new MyBot());
        builder.build();

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().equals(event.getJDA().getSelfUser())) {
            return;  // Ignore messages from the bot
        }

        String message = event.getMessage().getContentRaw();
        String link = scraper.hasYoutubeLink(message);

        if (link != null) {
            event.getChannel().sendMessage(link).queue();
        }
    }
}

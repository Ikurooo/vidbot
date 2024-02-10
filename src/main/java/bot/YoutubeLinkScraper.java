package bot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YoutubeLinkScraper {
    public YoutubeLinkScraper() {}

    public String hasYoutubeLink(String message) {
        // Regular expression pattern for a YouTube video URL
        String youtubeRegex = "(?i)(https?://)?(www\\.)?(youtube|youtu|youtube-nocookie)\\.(com|be)/"
                + "(watch\\?v=|embed/|v/|[^\"&'<>\\s]+)";


        Pattern pattern = Pattern.compile(youtubeRegex);
        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }
}

package com.afeka.moviesclient.runner;

import com.afeka.moviesclient.client.MovieClient;
import com.afeka.moviesclient.model.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * ════════════════════════════════════════════════════════════════
 *  משימה 4 — DemoRunner (תרחיש הדגמה מקצה לקצה)
 * ════════════════════════════════════════════════════════════════
 *
 * השלימו את הסעיפים המסומנים ב-TODO.
 * השתמשו בשיטות שמימשתם ב-MovieClient.
 */
@Component
public class DemoRunner implements CommandLineRunner {

    private final MovieClient movieClient;

    public DemoRunner(MovieClient movieClient) {
        this.movieClient = movieClient;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n================================================");
        System.out.println("  MOVIES CLIENT DEMO");
        System.out.println("================================================\n");

        // ── שלב 1 — GET כל הסרטים (מוכן לדוגמה) ─────────────────────────
        System.out.println("🎬 [GET] Fetching all movies...");
        List<Movie> movies = movieClient.getAllMovies();
        movies.forEach(m -> System.out.println("  → " + m));

        // ════════════════════════════════════════════════════════════════
        // TODO משימה 4א — GET סרט ספציפי לפי ID
        // ════════════════════════════════════════════════════════════════
        System.out.println("\n🔍 [GET] Fetching movie with ID=1...");
        // TODO: קראו ל- movieClient.getMovieById(1L)
        //       והשתמשו ב-.ifPresentOrElse() להדפסת התוצאה
        //       (ראו דוגמה בקובץ DemoRunner של הפרויקט books)


        // ════════════════════════════════════════════════════════════════
        // TODO משימה 4ב — GET סרטים לפי ז'אנר
        // ════════════════════════════════════════════════════════════════
        System.out.println("\n🎭 [GET] Fetching Sci-Fi movies...");
        // TODO: קראו ל- movieClient.getMoviesByGenre("Sci-Fi")
        //       והדפיסו את כל הסרטים שחזרו


        // ════════════════════════════════════════════════════════════════
        // TODO משימה 4ג — POST יצירת סרט חדש
        // ════════════════════════════════════════════════════════════════
        System.out.println("\n➕ [POST] Creating a new movie...");
        // TODO: צרו Movie חדש (בחרו סרט שאתם אוהבים!)
        //       קראו ל- movieClient.createMovie(newMovie)
        //       הדפיסו את הסרט שנוצר (כולל ה-ID שהוקצה)
        //       שמרו את ה-ID במשתנה newId לשימוש בהמשך


        // ════════════════════════════════════════════════════════════════
        // TODO משימה 4ד — DELETE מחיקת הסרט שנוצר
        // ════════════════════════════════════════════════════════════════
        System.out.println("\n🗑️  [DELETE] Deleting the new movie...");
        // TODO: מחקו את הסרט שיצרתם (השתמשו ב-newId)
        //       הדפיסו הודעת אישור


        // ════════════════════════════════════════════════════════════════
        // TODO משימה 4ה — אימות 404 אחרי המחיקה
        // ════════════════════════════════════════════════════════════════
        System.out.println("\n❓ [GET] Verifying deletion (expect 404)...");
        // TODO: נסו לקבל את הסרט שמחקתם
        //       ודאו שמקבלים Optional.empty() (404)
        //       הדפיסו "Confirmed 404 - movie was deleted ✅"


        System.out.println("\n================================================");
        System.out.println("  DEMO COMPLETE");
        System.out.println("================================================\n");
    }
}

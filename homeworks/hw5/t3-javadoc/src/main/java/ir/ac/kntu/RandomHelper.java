package ir.ac.kntu;

import java.util.Random;

/**
 * <h1>Random Helper Class</h1>
 * <p>This Is A Singleton Class</p>
 *
 * @author S.Shayan Daneshvar
 * <br>
 * <a href="mailto:daneshvarshayan@gmail.com">daneshvarshayan
 * {@code @}gmail.com</a>
 * <br>
 * <a href="https://shayandaneshvar.ir/">Author's Website</a>
 * @version 1.0
 * @see Random
 */
public final class RandomHelper {
    /**
     * Declaring 300 As The Seed Value
     */
    private static final Random RANDOM_GENERATOR = new Random(300);

    /**
     * Constructor Was Made Private So As to Make This Class A Singleton
     */
    private RandomHelper() {

    }

    /**
     * This Method Generates A Double value With The Seed Value Of 300
     *
     * @return A Pseudorandomly Generated Double Value
     */
    public static double nextDouble() {
        return RANDOM_GENERATOR.nextDouble();
    }

    /**
     * This Method Generates A Boolean value With The Seed Value Of 300
     *
     * @return A Pseudorandomly Generated Boolean Value
     */
    public static boolean nextBoolean() {
        return RANDOM_GENERATOR.nextBoolean();
    }

    /**
     * This Method Generates An Integer value With The Seed Value Of 300
     *
     * @return A Pseudorandomly Generated Int Value
     */
    public static int nextInt() {
        return RANDOM_GENERATOR.nextInt();
    }

    /**
     * This Method Generates An Integer value With The Seed Value Of 300
     *
     * @param bound A Positive Value That Defines The Upper Exclusive Bound
     * @return A Pseudorandomly Generated Double Value
     * @throws IllegalArgumentException if bound is not positive
     */
    public static int nextInt(int bound) {
        return RANDOM_GENERATOR.nextInt(bound);
    }
}

/**
 * Ein MusicPlayerListener ist ein Objekt, das �ber Ver�nderungen eines
 * MusicPlayers - wie die aktuelle Position - benachrichtigt werden m�chte.
 * @author Thomas Karp
 */
public interface MusicPlayerListener {
    /**
     * Wird vom MusicPlayer aufgerufen, wenn sich die Position im aktuellen Song �ndert.
     * Dazu muss man sich beim MusicPlayer als MusicPlayerListener anmelden.
     * @param newPosition Neue Position in Prozent.
     */
    void positionChanged(int newPosition);

}

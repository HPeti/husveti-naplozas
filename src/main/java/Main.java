import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final Marker KIJELENT = MarkerManager.getMarker("KIJELENT");
    private static final Marker KÉRELEM = MarkerManager.getMarker("KÉRELEM");

    public static void main(String[] args) throws InterruptedException {
        int iterationCount = 2;
        if(args.length == 1){
            iterationCount = Integer.parseInt(args[0]);
        }

        for (int i = 1; i <= iterationCount; i++){
            ThreadContext.put("iterationNumber", String.valueOf(i));

            logger.trace(KIJELENT, "Erdőn-mezőn nyitott szemmel,");
            logger.debug(KIJELENT, "sok virágra lel az ember.");
            logger.info(KIJELENT,"Én most őket megöntözöm,");
            logger.warn("a piros tojást megköszönöm!");
            logger.error(KÉRELEM, "Szabad-e locsolni?");

            ThreadContext.clearAll();
            Thread.sleep(1000);
        }
    }
}

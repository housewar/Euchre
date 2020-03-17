import CardDeck.*;
import Participants.*;
import Game.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

class RunTests {

    public static void main ( String args[] ){

        Result result = JUnitCore.runClasses(Card_Test.class);

        for (Failure failure : result.getFailures() ){
            System.out.println(failure.toString());
        }
        if ( result.wasSuccessful() ){
            System.out.println("Card tests completed successfully.");
        } else {
            System.out.println("One or more Card tests failed.");
        }

        result = JUnitCore.runClasses(Deck_Test.class);

        for (Failure failure : result.getFailures() ){
            System.out.println(failure.toString());
        }
        if ( result.wasSuccessful() ){
            System.out.println("Deck tests completed successfully.");
        } else {
            System.out.println("One or more Deck tests failed.");
        }

        result = JUnitCore.runClasses(Cards_Test.class);

        for (Failure failure : result.getFailures() ){
        System.out.println(failure.toString());
        }
            if ( result.wasSuccessful() ){
            System.out.println("Cards tests completed successfully.");
        } else {
            System.out.println("One or more Cards tests failed.");
        }

        result = JUnitCore.runClasses(EuchreCardTrumpLogic_Test.class);

        for (Failure failure : result.getFailures() ){
            System.out.println(failure.toString());
        }
        if ( result.wasSuccessful() ){
            System.out.println("Euchre Logic tests completed successfully.");
        } else {
            System.out.println("One or more Euchre Logic tests failed.");
        }

        result = JUnitCore.runClasses(PlayableHand_Test.class);

        for (Failure failure : result.getFailures() ){
            System.out.println(failure.toString());
        }
        if ( result.wasSuccessful() ){
            System.out.println("Playable Hand tests completed successfully.");
        } else {
            System.out.println("One or more Playable Hand tests failed.");
        }

        result = JUnitCore.runClasses(Player_Test.class);

        for (Failure failure : result.getFailures() ){
            System.out.println(failure.toString());
        }
        if ( result.wasSuccessful() ){
            System.out.println("Player tests completed successfully.");
        } else {
            System.out.println("One or more Player tests failed.");
        }

        result = JUnitCore.runClasses(PlayerCard_Test.class);

        for (Failure failure : result.getFailures() ){
            System.out.println(failure.toString());
        }
        if ( result.wasSuccessful() ){
            System.out.println("PlayerCard tests completed successfully.");
        } else {
            System.out.println("One or more PlayerCard tests failed.");
        }

        result = JUnitCore.runClasses(PlayerCards_Test.class);

        for (Failure failure : result.getFailures() ){
            System.out.println(failure.toString());
        }
        if ( result.wasSuccessful() ){
            System.out.println("PlayerCards tests completed successfully.");
        } else {
            System.out.println("One or more PlayerCards tests failed.");
        }
    }
}

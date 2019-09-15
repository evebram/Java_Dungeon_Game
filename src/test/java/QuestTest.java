import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestTest {

    Quest quest1;
    Quest quest2;

    @Before
    public void setUp(){
        this.quest1 = new Quest(2);
        this.quest2 = new Quest(4);
    }

    @Test
    public void canGenerateQuest1(){
        quest1.generateQuest();
        assertEquals(2, quest1.getQuestLength());
    }

    @Test
    public void canGenerateQuest2(){
        quest2.generateQuest();
        assertEquals(4, quest2.getQuestLength());
    }

    @Test
    public void canGenerateParty(){
        quest1.generateParty();
        assertEquals(3, quest1.getPartySize());
        assertEquals(80, quest1.getPartyStats(0));
        assertEquals(160, quest1.getPartyStats(1));
        assertEquals(120, quest1.getPartyStats(2));
    }

    @Test
    public void canCheckRoomContents(){
        quest1.generateQuest();
        assertEquals(1, quest1.getQuestRoom(0));
        assertEquals(1, quest1.getQuestRoom(1));
    }


//    @Test
//    public void canCheckIfCompleteTrue(){
//        quest1.generateQuest();
//        quest1.runQuest();
//        assertEquals("Quest completed", quest1.isQuestComplete());
//    }

}

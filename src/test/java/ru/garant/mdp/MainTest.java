package ru.garant.mdp;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
public class MainTest {
	
    @Autowired
    private SessionFactory sessionFactory;
	private Session session;
	private Transaction tx;
    
    @Before
    public void before () {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.setFlushMode(FlushMode.COMMIT);
    }
    
    @After
    public void after () {
    	tx.commit();
    	session.close();
    }
    
    @Test
    public void shouldHaveASessionFactory() {
        assertNotNull(sessionFactory);
    }
    
	@Test
	public void shouldFindModelByField () {
		Model model = createRandomModel();
		session.save(model);

		model.setField0("TEST1");
		session.save(model);
			
		assertTrue(null != session.createSQLQuery("select id from model where field0 = '" + model.getField0() + "'").uniqueResult());
	}
	
	@Test
	public void shouldNotCrashWithOutOfMemory () {
		for (int i = 1; i <= 1000000; i++) {
			Model model = createRandomModel();
			session.save(model);
			
			if (i % 10000 == 0) {
				System.out.println ("processed: " + i);
				
				tx.commit();
				tx = session.beginTransaction();
			}
		}
	}
	
	private Model createRandomModel () {
		Model ret = new Model ();
		ret.setField0(RandomStringUtils.randomAlphanumeric(200));
		ret.setField1(RandomStringUtils.randomAlphanumeric(200));
		ret.setField2(RandomStringUtils.randomAlphanumeric(200));
		ret.setField3(RandomStringUtils.randomAlphanumeric(200));
		ret.setField4(RandomStringUtils.randomAlphanumeric(200));
		ret.setField5(RandomStringUtils.randomAlphanumeric(200));
		ret.setField6(RandomStringUtils.randomAlphanumeric(200));
		ret.setField7(RandomStringUtils.randomAlphanumeric(200));
		ret.setField8(RandomStringUtils.randomAlphanumeric(200));
		ret.setField9(RandomStringUtils.randomAlphanumeric(200));
		return ret;
	}

}

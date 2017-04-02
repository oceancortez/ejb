package org.oc.test;

import org.junit.runner.RunWith;
import org.oc.jpa.JPAFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
@ComponentScan("org.oc")
@Import(JPAFilter.class)
public abstract class AbstractDatabaseTest {

}

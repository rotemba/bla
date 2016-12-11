package bgu.spl.a2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 10/12/2016.
 */
public class VersionMonitorTest {
	VersionMonitor verMon = new VersionMonitor(0);
	@Test
	public void getVersion() throws Exception {
		int i = verMon.getVersion();
		assertEquals(1,i);
	
		verMon.inc();;
		i = verMon.getVersion();
		assertEquals(1,i);
		
		
		
	}

	@Test
	public void inc() throws Exception {
//		VersionMonitor verMon = new VersionMonitor(0);
		int i = verMon.getVersion();
		verMon.inc();
		verMon.inc();
		verMon.inc();
		verMon.inc();
		int inc = verMon.getVersion();
		assertEquals(i+4,inc);
	}

	@Test
	public void await() throws Exception {
		System.out.println(verMon.getVersion());
		verMon.await(0);
		verMon.await(1);
	}

}
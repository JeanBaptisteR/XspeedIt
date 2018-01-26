package com.jbrobert;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PackagerTest {

    Packager packager;

    @Before
    public void init() {
        packager = new Packager();
    }

    @Test
    public final void noItemPackagingTest(){
        // Test the case where there is no item to package
        List<Integer> items = Arrays.asList();
        Assert.assertEquals(0, packager.optimizedItemPackaging(items).size());
    }

    @Test
    public final void packagingTest(){
        // Test the case where there are several items to package
        List<Integer> items = Arrays.asList(1, 9, 3, 8);
        Assert.assertEquals(3, packager.optimizedItemPackaging(items).size());
    }

    @Test
    public final void standardPackagingTest(){
        // Test provided in the problem description
        List<Integer> items = Arrays.asList(1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3);
        Assert.assertEquals(8, packager.optimizedItemPackaging(items).size());
    }
}

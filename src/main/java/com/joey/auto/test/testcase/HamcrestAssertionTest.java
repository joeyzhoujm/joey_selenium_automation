package com.joey.auto.test.testcase;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


//Hamcrest 风格断言，更贴近英语
class HamcrestAssertionTest {

    @Test
    void test() {
        String actual = "test";
        String expected = "test";
        String[] actualArray = new String[]{"a", "b"};
        List<String> actualList = Arrays.asList(actualArray);
        Map<String, String> actualMap = new HashMap<>();
        actualMap.put("name", "zhangsan");

        // assert Number
        assertThat(1.0, greaterThan(0.9));
        assertThat(1.0, greaterThanOrEqualTo(0.9));
        assertThat(1.0, lessThan(1.2));
        assertThat(1.0, lessThanOrEqualTo(1.2));
        assertThat(1.2, comparesEqualTo(1.2));
        assertThat(1.01, closeTo(1.0, 0.03));
        assertThat(Double.NaN, notANumber());

        // assert Text
        assertThat(actual, equalTo(expected));
        assertThat(actual, equalToIgnoringCase(expected));
        assertThat(actual, equalToCompressingWhiteSpace(expected));
        assertThat(actual, startsWith(expected));
        assertThat(actual, startsWithIgnoringCase(expected));
        assertThat(actual, endsWith(expected));
        assertThat(actual, endsWithIgnoringCase(expected));
        assertThat("", blankOrNullString());
        assertThat("", blankString());
        assertThat("", emptyOrNullString());
        assertThat("", emptyString());
        assertThat(actual, containsString("t"));
        assertThat(actual, containsStringIgnoringCase("t"));
        assertThat(actual, stringContainsInOrder("te"));
        assertThat(actual, both(containsString("t")).and(containsString("e")));
        assertThat(actual, either(containsString("t")).or(containsString("e")));
        assertThat("a", in(actualArray));
        assertThat("a", oneOf("a", "b"));
        assertThat(actual, hasLength(4));
        assertThat(actual, matchesPattern(".*"));
        assertThat(actual, matchesRegex(".*"));

        // assert Object
        assertThat(actual, equalToObject(expected));
        assertThat(actual, notNullValue());
        assertThat(null, nullValue());
        assertThat(actual, isA(String.class));
        assertThat(actual, instanceOf(String.class));
        assertThat(actual, any(String.class));
        assertThat(actual, sameInstance(expected));
        assertThat(actual, hasToString(expected));
        assertThat(actual, anything());
        assertThat(actual, is(anything())); // is 是语法糖，没有实际作用
        assertThat(actual, describedAs("actual is anything", anything()));

        // assert Map
        assertThat(actualMap, hasKey(equalTo("name")));
        assertThat(actualMap, hasValue(equalTo("zhangsan")));
        assertThat(actualMap, hasEntry(equalTo("name"), equalTo("zhangsan")));
        assertThat(actualMap, aMapWithSize(1));
        assertThat(new HashMap<>(), anEmptyMap());

        // assert Array and List
        assertThat(actualArray, array(equalTo("a"), equalTo("b")));
        assertThat(actualArray, arrayContaining(equalTo("a"), equalTo("b")));
        assertThat(actualArray, arrayContainingInAnyOrder(equalTo("a"), equalTo("b")));
        assertThat(actualArray, hasItemInArray(equalTo("a")));
        assertThat(actualArray, arrayWithSize(2));
        assertThat(new String[]{}, emptyArray());

        assertThat(actualList, hasItem(equalTo("a")));
        assertThat(actualList, hasItems(equalTo("a"), equalTo("b")));
        assertThat(actualList, contains(equalTo("a"), equalTo("b")));
        assertThat(actualList, containsInAnyOrder(equalTo("a"), equalTo("b")));
        assertThat(actualList, containsInRelativeOrder(equalTo("a"), equalTo("b")));
        assertThat(new ArrayList<>(), empty());
        assertThat(new ArrayList<>(), emptyIterable());
        assertThat(new ArrayList<>(), emptyCollectionOf(String.class));
        assertThat(actualList, everyItem(hasLength(1)));
        assertThat(actualList, hasSize(2));
        assertThat(actualList, iterableWithSize(2));

        // assert Beans
//		assertThat(actual, hasProperty("value"));

        // allOf, like Java &&
        // anyOf, like Java ||
        // not,   like Java !
        assertThat(actual, allOf(is("test"), is(not(("")))));
        assertThat(actual, anyOf(is(""), is(not(("")))));
        assertThat(actual, is(not("")));
    }

}


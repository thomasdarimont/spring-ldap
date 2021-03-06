/*
 * Copyright 2005-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ldap.filter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the OrFilter class.
 * 
 * @author Adam Skogman
 */
public class OrFilterTest {

    @Test
    public void testZero() {
        OrFilter of = new OrFilter();

        assertEquals("", of.encode());
    }

    @Test
    public void testOne() {
        OrFilter of = new OrFilter().or(new EqualsFilter("a", "b"));

        assertEquals("(a=b)", of.encode());
    }

    @Test
    public void testTwo() {
        OrFilter of = new OrFilter().or(new EqualsFilter("a", "b")).or(
                new EqualsFilter("c", "d"));

        assertEquals("(|(a=b)(c=d))", of.encode());
    }

    @Test
    public void testThree() {
        OrFilter of = new OrFilter().or(new EqualsFilter("a", "b")).or(
                new EqualsFilter("c", "d")).or(new EqualsFilter("e", "f"));

        assertEquals("(|(a=b)(c=d)(e=f))", of.encode());
    }

}

/* 
 * JBoss, Home of Professional Open Source 
 * Copyright 2010-2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved. 
 * See the copyright.txt in the distribution for a 
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use, 
 * modify, copy, or redistribute it subject to the terms and conditions 
 * of the GNU Lesser General Public License, v. 2.1. 
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more 
 * details. You should have received a copy of the GNU Lesser General Public 
 * License, v.2.1 along with this distribution; if not, write to the Free 
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  
 * 02110-1301, USA.
 */

package org.switchyard.quickstarts.demos.orders;

import org.junit.Assert;
import org.junit.Test;
import org.switchyard.test.SwitchYardTestCase;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.mixins.CDIMixIn;

@SwitchYardTestCaseConfig(mixins = CDIMixIn.class)
public class OrderServiceTest extends SwitchYardTestCase {

    @Test
    public void testOrderAccepted() throws Exception {
        Order testOrder = new Order()
            .setOrderId("ORDER01")
            .setItemId("BUTTER")
            .setQuantity(100);
        
        OrderAck testAck = newInvoker("OrderService")
            .operation("submitOrder")
            .sendInOut(testOrder)
            .getContent(OrderAck.class);

        Assert.assertTrue(testAck.isAccepted());
    }
}
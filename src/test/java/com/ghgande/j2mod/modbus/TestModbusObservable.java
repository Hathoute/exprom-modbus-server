/*
 * Copyright 2002-2016 jamod & j2mod development teams
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ghgande.j2mod.modbus;

import com.ghgande.j2mod.modbus.procimg.ObservableRegister;
import com.ghgande.j2mod.modbus.utils.AbstractTestModbusTCPSlaveNonCoupler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class uses an external master tool to test that the j2mod slave observable interface works OK
 * master
 *
 * @author Steve O'Hara (4NG)
 * @version 2.0 (March 2016)
 */
public class TestModbusObservable extends AbstractTestModbusTCPSlaveNonCoupler {

    @Test
    public void testObservableRegister() {
        assertTrue("Incorrect write status for holding register 1", writeModPoll(1, 4, 5555, "Written 1 reference"));
        assertTrue("Incorrect value for holding register 1", readModPoll(1, 4, "[1]: 5555"));
        assertEquals("Update method never called on observable holding register", 5555, ((ObservableRegister)updatedRegister).getValue());
    }

}

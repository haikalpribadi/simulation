/*
 * Copyright (C) 2020 Grakn Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package grakn.simulation.common.agent.insight;

import grakn.simulation.common.action.ActionFactory;
import grakn.simulation.common.action.read.ReadAction;
import grakn.simulation.common.agent.base.SimulationContext;
import grakn.simulation.common.driver.DbDriver;
import grakn.simulation.common.driver.DbOperation;

public class FindSpecificMarriageAgent<DB_OPERATION extends DbOperation> extends WorldwideInsightAgent<DB_OPERATION> {
    public FindSpecificMarriageAgent(DbDriver<DB_OPERATION> dbDriver, ActionFactory<DB_OPERATION, ?> actionFactory, SimulationContext simulationContext) {
        super(dbDriver, actionFactory, simulationContext);
    }

    @Override
    protected ReadAction<DB_OPERATION, ?> getAction(DB_OPERATION dbOperation) {
        return actionFactory().findSpecificMarriageAction(dbOperation);
    }
}

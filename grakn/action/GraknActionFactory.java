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

package grakn.simulation.grakn.action;

import grakn.client.concept.answer.ConceptMap;
import grakn.common.collection.Pair;
import grakn.simulation.common.action.ActionFactory;
import grakn.simulation.common.action.SpouseType;
import grakn.simulation.common.action.read.BirthsInCityAction;
import grakn.simulation.common.action.read.CitiesInContinentAction;
import grakn.simulation.common.action.insight.FindCurrentResidentsAction;
import grakn.simulation.common.action.insight.FindLivedInAction;
import grakn.simulation.common.action.insight.FindSpecificMarriageAction;
import grakn.simulation.common.action.insight.FindSpecificPersonAction;
import grakn.simulation.common.action.insight.FindTransactionCurrencyAction;
import grakn.simulation.common.action.insight.FourHopAction;
import grakn.simulation.common.action.insight.ArbitraryOneHopAction;
import grakn.simulation.common.action.read.MarriedCoupleAction;
import grakn.simulation.common.action.insight.MeanWageOfPeopleInWorldAction;
import grakn.simulation.common.action.read.ProductsInContinentAction;
import grakn.simulation.common.action.insight.ThreeHopAction;
import grakn.simulation.common.action.insight.TwoHopAction;
import grakn.simulation.common.action.read.UnmarriedPeopleInCityAction;
import grakn.simulation.common.action.write.UpdateAgesOfPeopleInCityAction;
import grakn.simulation.common.action.write.InsertCompanyAction;
import grakn.simulation.common.action.write.InsertEmploymentAction;
import grakn.simulation.common.action.write.InsertFriendshipAction;
import grakn.simulation.common.action.write.InsertMarriageAction;
import grakn.simulation.common.action.write.InsertParentShipAction;
import grakn.simulation.common.action.write.InsertPersonAction;
import grakn.simulation.common.action.write.InsertProductAction;
import grakn.simulation.common.action.write.InsertRelocationAction;
import grakn.simulation.common.action.write.InsertTransactionAction;
import grakn.simulation.common.world.World;
import grakn.simulation.grakn.action.read.GraknBirthsInCityAction;
import grakn.simulation.grakn.action.read.GraknCitiesInContinentAction;
import grakn.simulation.grakn.action.read.GraknCompaniesInCountryAction;
import grakn.simulation.grakn.action.insight.GraknFindCurrentResidentsAction;
import grakn.simulation.grakn.action.insight.GraknFindLivedInAction;
import grakn.simulation.grakn.action.insight.GraknFindSpecificMarriageAction;
import grakn.simulation.grakn.action.insight.GraknFindSpecificPersonAction;
import grakn.simulation.grakn.action.insight.GraknFindTransactionCurrencyAction;
import grakn.simulation.grakn.action.insight.GraknFourHopAction;
import grakn.simulation.grakn.action.insight.GraknArbitraryOneHopAction;
import grakn.simulation.grakn.action.read.GraknMarriedCoupleAction;
import grakn.simulation.grakn.action.insight.GraknMeanWageOfPeopleInWorldAction;
import grakn.simulation.grakn.action.read.GraknProductsInContinentAction;
import grakn.simulation.grakn.action.read.GraknResidentsInCityAction;
import grakn.simulation.grakn.action.insight.GraknThreeHopAction;
import grakn.simulation.grakn.action.insight.GraknTwoHopAction;
import grakn.simulation.grakn.action.read.GraknUnmarriedPeopleInCityAction;
import grakn.simulation.grakn.action.write.GraknUpdateAgesOfPeopleInCityAction;
import grakn.simulation.grakn.action.write.GraknInsertCompanyAction;
import grakn.simulation.grakn.action.write.GraknInsertEmploymentAction;
import grakn.simulation.grakn.action.write.GraknInsertFriendshipAction;
import grakn.simulation.grakn.action.write.GraknInsertMarriageAction;
import grakn.simulation.grakn.action.write.GraknInsertParentShipAction;
import grakn.simulation.grakn.action.write.GraknInsertPersonAction;
import grakn.simulation.grakn.action.write.GraknInsertProductAction;
import grakn.simulation.grakn.action.write.GraknInsertRelocationAction;
import grakn.simulation.grakn.action.write.GraknInsertTransactionAction;
import grakn.simulation.grakn.driver.GraknOperation;

import java.time.LocalDateTime;
import java.util.HashMap;

public class GraknActionFactory extends ActionFactory<GraknOperation, ConceptMap> {

    @Override
    public GraknResidentsInCityAction residentsInCityAction(GraknOperation dbOperation, World.City city, int numResidents, LocalDateTime earliestDate) {
        return new GraknResidentsInCityAction(dbOperation, city, numResidents, earliestDate);
    }

    @Override
    public GraknCompaniesInCountryAction companiesInCountryAction(GraknOperation dbOperation, World.Country country, int numCompanies) {
        return new GraknCompaniesInCountryAction(dbOperation, country, numCompanies);
    }

    @Override
    public InsertEmploymentAction<GraknOperation, ConceptMap> insertEmploymentAction(GraknOperation dbOperation, World.City city, String employeeEmail, long companyNumber, LocalDateTime employmentDate, double wageValue, String contractContent, double contractedHours) {
        return new GraknInsertEmploymentAction(dbOperation, city, employeeEmail, companyNumber, employmentDate, wageValue, contractContent, contractedHours);
    }

    @Override
    public InsertCompanyAction<GraknOperation, ConceptMap> insertCompanyAction(GraknOperation dbOperation, World.Country country, LocalDateTime today, int companyNumber, String companyName) {
        return new GraknInsertCompanyAction(dbOperation, country, today, companyNumber, companyName);
    }

    @Override
    public InsertFriendshipAction<GraknOperation, ConceptMap> insertFriendshipAction(GraknOperation dbOperation, LocalDateTime today, String friend1Email, String friend2Email) {
        return new GraknInsertFriendshipAction(dbOperation, today, friend1Email, friend2Email);
    }

    @Override
    public UnmarriedPeopleInCityAction<GraknOperation> unmarriedPeopleInCityAction(GraknOperation dbOperation, World.City city, String gender, LocalDateTime dobOfAdults) {
        return new GraknUnmarriedPeopleInCityAction(dbOperation, city, gender, dobOfAdults);
    }

    @Override
    public InsertMarriageAction<GraknOperation, ConceptMap> insertMarriageAction(GraknOperation dbOperation, World.City city, int marriageIdentifier, String wifeEmail, String husbandEmail) {
        return new GraknInsertMarriageAction(dbOperation, city, marriageIdentifier, wifeEmail, husbandEmail);
    }

    @Override
    public BirthsInCityAction<GraknOperation> birthsInCityAction(GraknOperation dbOperation, World.City city, LocalDateTime today) {
        return new GraknBirthsInCityAction(dbOperation, city, today);
    }

    @Override
    public MarriedCoupleAction<GraknOperation> marriedCoupleAction(GraknOperation dbOperation, World.City city, LocalDateTime today) {
        return new GraknMarriedCoupleAction(dbOperation, city, today);
    }

    @Override
    public InsertParentShipAction<GraknOperation, ConceptMap> insertParentshipAction(GraknOperation dbOperation, HashMap<SpouseType, String> marriage, String childEmail) {
        return new GraknInsertParentShipAction(dbOperation, marriage, childEmail);
    }

    @Override
    public InsertPersonAction<GraknOperation, ConceptMap> insertPersonAction(GraknOperation dbOperation, World.City city, LocalDateTime today, String email, String gender, String forename, String surname) {
        return new GraknInsertPersonAction(dbOperation, city, today, email, gender, forename, surname);
    }

    @Override
    public InsertProductAction<GraknOperation, ConceptMap> insertProductAction(GraknOperation dbOperation, World.Continent continent, Long barcode, String productName, String productDescription) {
        return new GraknInsertProductAction(dbOperation, continent, barcode, productName, productDescription);
    }

    @Override
    public CitiesInContinentAction<GraknOperation> citiesInContinentAction(GraknOperation dbOperation, World.City city) {
        return new GraknCitiesInContinentAction(dbOperation, city);
    }

    @Override
    public InsertRelocationAction<GraknOperation, ConceptMap> insertRelocationAction(GraknOperation dbOperation, World.City city, LocalDateTime today, String residentEmail, String relocationCityName) {
        return new GraknInsertRelocationAction(dbOperation, city, today, residentEmail, relocationCityName);
    }
    
    @Override
    public ProductsInContinentAction<GraknOperation> productsInContinentAction(GraknOperation dbOperation, World.Continent continent) {
        return new GraknProductsInContinentAction(dbOperation, continent);
    }

    @Override
    public InsertTransactionAction<GraknOperation, ConceptMap> insertTransactionAction(GraknOperation dbOperation, World.Country country, Pair<Long, Long> transaction, Long sellerCompanyNumber, double value, int productQuantity, boolean isTaxable) {
        return new GraknInsertTransactionAction(dbOperation, country, transaction, sellerCompanyNumber, value, productQuantity, isTaxable);
    }

    @Override
    public UpdateAgesOfPeopleInCityAction<GraknOperation> updateAgesOfPeopleInCityAction(GraknOperation dbOperation, LocalDateTime today, World.City city) {
        return new GraknUpdateAgesOfPeopleInCityAction(dbOperation, today, city);
    }

    @Override
    public MeanWageOfPeopleInWorldAction<GraknOperation> meanWageOfPeopleInWorldAction(GraknOperation dbOperation) {
        return new GraknMeanWageOfPeopleInWorldAction(dbOperation);
    }

    @Override
    public FindLivedInAction<GraknOperation> findlivedInAction(GraknOperation dbOperation) {
        return new GraknFindLivedInAction(dbOperation);
    }

    @Override
    public FindCurrentResidentsAction<GraknOperation> findCurrentResidentsAction(GraknOperation dbOperation) {
        return new GraknFindCurrentResidentsAction(dbOperation);
    }

    @Override
    public FindTransactionCurrencyAction<GraknOperation> findTransactionCurrencyAction(GraknOperation dbOperation) {
        return new GraknFindTransactionCurrencyAction(dbOperation);
    }

    @Override
    public ArbitraryOneHopAction<GraknOperation> arbitraryOneHopAction(GraknOperation dbOperation) {
        return new GraknArbitraryOneHopAction(dbOperation);
    }

    @Override
    public TwoHopAction<GraknOperation> twoHopAction(GraknOperation dbOperation) {
        return new GraknTwoHopAction(dbOperation);
    }

    @Override
    public ThreeHopAction<GraknOperation> threeHopAction(GraknOperation dbOperation) {
        return new GraknThreeHopAction(dbOperation);
    }

    @Override
    public FourHopAction<GraknOperation> fourHopAction(GraknOperation dbOperation) {
        return new GraknFourHopAction(dbOperation);
    }

    @Override
    public FindSpecificMarriageAction<GraknOperation> findSpecificMarriageAction(GraknOperation dbOperation) {
        return new GraknFindSpecificMarriageAction(dbOperation);
    }

    @Override
    public FindSpecificPersonAction<GraknOperation> findSpecificPersonAction(GraknOperation dbOperation) {
        return new GraknFindSpecificPersonAction(dbOperation);
    }
}

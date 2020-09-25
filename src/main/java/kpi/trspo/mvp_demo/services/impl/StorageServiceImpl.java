package kpi.trspo.mvp_demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kpi.trspo.mvp_demo.services.StorageService;
import kpi.trspo.mvp_demo.services.models.goods.*;
import kpi.trspo.mvp_demo.services.models.work.*;
import kpi.trspo.mvp_demo.services.models.workers.Cashier;

@Service
public class StorageServiceImpl implements StorageService {
	@Autowired
	private DogStorage dogStorage;
	
	@Autowired
	private ForDogStorage forDogStorage;

	@Override
	public String getStorageState() {
		return  "Залишок тварин:\n" +
				"Бульдоги:  " + dogStorage.getNumberOfBulldogs() + "\n" +
				"Хаскі:     " + dogStorage.getNumberOfHuskies() + "\n" +
				"Лабрадори: " + dogStorage.getNumberOfLabradors() + "\n" +
				"Пуделі:    " + dogStorage.getNumberOfPoodles() + "\n" +
				"Ретривери: " + dogStorage.getNumberOfRetrievers() + "\n" +
				"Терєри:    " + dogStorage.getNumberOfTerriers() + "\n" + "Залишок аксесуарів:\n" +
				"Повідки:   " + forDogStorage.getNumberOfLeashes() + "\n" +
				"Їжа:       " + forDogStorage.getNumberOfFeed() + "\n" +
				"Будиночки: " + forDogStorage.getNumberOfCages() + "\n";
	}

	@Override
	public void sellFromStore(Cashier cashier, CashRegister cashRegister, Dog dog) {
		final int newAmountOfCash = cashRegister.getAmountOfCash() + dog.getPrice();

		cashRegister.setAmountOfCash(newAmountOfCash);
		dogStorage.takeFromStorage(dog);
		cashier.purchaseReport(dog);
	}

	@Override
	public void sellFromStore(Cashier cashier, CashRegister cashRegister, ForDog forDog) {
		final int newAmountOfCash = cashRegister.getAmountOfCash() + forDog.getPrice();

		cashRegister.setAmountOfCash(newAmountOfCash);
		forDogStorage.takeFromStorage(forDog);
		cashier.purchaseReport(forDog);
	}
	
	@Override
	public void sellFromStore(Cashier cashier, CashRegister cashRegister, ServiceForDog service) {
		final int newAmountOfCash = cashRegister.getAmountOfCash() + service.getPrice();
		
		cashRegister.setAmountOfCash(newAmountOfCash);
		cashier.purchaseReport(service);
	}

	@Override
	public void takeInStore(Dog dog) {
		dogStorage.putInStorage(dog);
	}

	@Override
	public void takeInStore(ForDog forDog) {
		forDogStorage.putInStorage(forDog);
	}
}


package com.mmpharmacy.mmpharmacy.service.impl;

import com.mmpharmacy.mmpharmacy.entity.Country;
import com.mmpharmacy.mmpharmacy.entity.Supplier;
import com.mmpharmacy.mmpharmacy.repo.RepoCountry;
import com.mmpharmacy.mmpharmacy.repo.RepoSupplier;
import com.mmpharmacy.mmpharmacy.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final RepoSupplier repoSupplier;
    private final RepoCountry repoCountry;

    @Override
    public void findAllByIsActive(Model md) {
        List<Supplier> suppliers = repoSupplier.findAllByIsactive("1");
        List<Country> countries = repoCountry.findAllByOrderByCountryid();
        md.addAttribute("supplier", suppliers);
        md.addAttribute("countriess", countries);
    }

    @Override
    public void deleteSupplierById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Supplier sup = repoSupplier.getOne(id);
        sup.setIsactive("0");
        repoSupplier.save(sup);
    }

    @Override
    public void addSupplier(int countryid, String name, String email, String phonenumber, String address) {
        Country cnt = repoCountry.getOne(countryid);
        Supplier sup = new Supplier(name, address, phonenumber, email, "1");
        sup.setCountry(cnt);
        repoSupplier.save(sup);
    }

    @Override
    public void updateSupplier(int id, int countryid, String name, String email, String phonenumber, String address) {
        Supplier sup = repoSupplier.getOne(id);
        Country cnt = repoCountry.getOne(countryid);
        sup.setEmail(email);
        sup.setAddress(address);
        sup.setName(name);
        sup.setPhonenumber(phonenumber);
        sup.setCountry(cnt);
        repoSupplier.save(sup);
    }
}

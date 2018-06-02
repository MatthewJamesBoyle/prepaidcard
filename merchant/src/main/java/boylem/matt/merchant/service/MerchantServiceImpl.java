package boylem.matt.merchant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boylem.matt.merchant.dao.MerchantDao;
import boylem.matt.merchant.domain.Merchant;
import utils.ErrorType;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	MerchantDao merchantDao;

	public ResponseEntity<?> create(Merchant merchant) {
		if (merchant == null) {
			return new ResponseEntity<ErrorType>(new ErrorType("ERROR: Could not create a Merchant."),
					HttpStatus.BAD_REQUEST);
		}

		merchantDao.save(merchant);

		return new ResponseEntity<Merchant>(merchant, HttpStatus.OK);
	}

}


package com.njoroge.is.service.register;

import org.springframework.stereotype.Service;

import com.njoroge.is.service.shared.SaveResponse;

@Service
public class RegisterServiceImpl implements
        RegisterService {

    @Override
    public RegisterInitialData getInitialData() {

        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public SaveResponse save( RegisterRequest sellerAddBuyerRequest,
            String domain ) {

        // TODO Auto-generated method stub
        return null;
    }
    //
    // @Autowired
    // private AddressTypeRepository addressTypeRepository;
    //
    // @Autowired
    // private AddressRepository addressRepository;
    //
    // @Autowired
    // private UserRepository userRepository;
    //
    // @Autowired
    // private HashHelper hashHelper;
    //
    // public RegisterServiceImpl() {
    //
    // }
    //
    // private User createUser( RegisterRequest adminAddSellerRequest ) {
    //
    // User user = new User();
    // user.setCreatedDate( Calendar.getInstance() );
    // user.setEmail( adminAddSellerRequest.getEmail().toLowerCase() );
    // user.setFirstName( adminAddSellerRequest.getFirstName() );
    // user.setLastName( adminAddSellerRequest.getLastName() );
    // user.setPassword( adminAddSellerRequest.getPassword() );
    // return user;
    // }
    //
    //
    // private Address saveAddress( RegisterRequest sellerAddBuyerRequest ) {
    //
    // Address address = new Address();
    // AddressType addressType = new AddressType();
    // Country country = new Country();
    //
    // addressType = addressTypeRepository.findOne( sellerAddBuyerRequest
    // .getAddressTypeId() );
    //
    // country = countryRepository.findOne( sellerAddBuyerRequest
    // .getCountryId() );
    //
    // address.setAddressType( addressType );
    // address.setCountry( country );
    //
    // address.setFirstLine( Malicious.escapeMalicious( sellerAddBuyerRequest
    // .getFirstLine() ) );
    //
    // address.setSecondLine( Malicious.escapeMalicious( sellerAddBuyerRequest
    // .getSecondLine() ) );
    //
    // address.setThirdLine( Malicious.escapeMalicious( sellerAddBuyerRequest
    // .getThirdLine() ) );
    //
    // address.setFourthLine( Malicious.escapeMalicious( sellerAddBuyerRequest
    // .getFourthLine() ) );
    //
    // address.setTownOrCity( Malicious.escapeMalicious( sellerAddBuyerRequest
    // .getTownOrCity() ) );
    //
    // address.setPostCode( Malicious.escapeMalicious( sellerAddBuyerRequest
    // .getPostCode() ) );
    //
    // addressRepository.save( address );
    // return address;
    // }
    //
    //
    // private boolean checkIfEmailExists( String email ) {
    //
    // if ( userRepository.findByEmail( email ) == null ) {
    // return false;
    // }
    //
    // return true;
    // }
    //
    //
    // @Override
    // public RegisterInitialData getInitialData() {
    //
    // AddressTypeTransfer[] addressTypes = getBuyerAddressTypeTransfers();
    // CountryTransfer[] countries = getCountryTransfers();
    //
    // RegisterInitialData sellerAddBuyerInitialData = new RegisterInitialData(
    // addressTypes, countries );
    //
    // return sellerAddBuyerInitialData;
    // }
    //
    //
    // @Override
    // @Transactional
    // public SaveResponse save( RegisterRequest registerRequest, String domain
    // ) {
    //
    // String email = Malicious.escapeMalicious( registerRequest.getEmail() );
    // SaveResponse saveResponse = null;
    //
    // if ( checkIfEmailExists( email ) ) {
    //
    // saveResponse = new SaveResponse( false, "Email " + registerRequest
    // .getEmail() + " is already in use." );
    // }
    // else {
    //
    // List<Address> addressList = new ArrayList<>();
    // User user;
    // user = createUser( registerRequest );
    //
    // String hashPassword = hashHelper.getPasswordHashWithBcrypt(
    // registerRequest.getPassword() );
    //
    // user.setPassword( hashPassword );
    // User savedUser = userRepository.save( user );
    //
    // Address address = saveAddress( registerRequest );
    // addressList.add( address );
    //
    // saveResponse = addNewBuyer( savedUser, contact, registerRequest,
    // domain );
    // }
    //
    // return saveResponse;
    // }
}

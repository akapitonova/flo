package com.kap.flowershop.back.mapping;

import com.kap.flowershop.back.entity.Users;
import com.kap.flowershop.back.entity_props.UserProperties;
import com.kap.flowershop.front.dto.UserDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T21:32:09+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto entityToDto(Users user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setFirstName( userUserPropertiesFirstName( user ) );
        userDto.setLastName( userUserPropertiesLastName( user ) );
        userDto.setCustomerPhone( userUserPropertiesCustomerPhone( user ) );
        userDto.setShippingAddress( userUserPropertiesShippingAddress( user ) );
        userDto.setBalance( userUserPropertiesBalance( user ) );
        userDto.setDiscount( userUserPropertiesDiscount( user ) );
        if ( user.getUserId() != null ) {
            userDto.setUserId( String.valueOf( user.getUserId() ) );
        }
        userDto.setUserName( user.getUserName() );
        userDto.setRole( user.getRole() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }

    @Override
    public Users dtoToEntity(UserDto user) {
        if ( user == null ) {
            return null;
        }

        Users users = new Users();

        users.setUserProperties( userDtoToUserProperties( user ) );
        if ( user.getUserId() != null ) {
            users.setUserId( Long.parseLong( user.getUserId() ) );
        }
        users.setUserName( user.getUserName() );
        users.setPassword( user.getPassword() );
        users.setRole( user.getRole() );

        return users;
    }

    @Override
    public List<UserDto> toListDto(List<Users> list) {
        if ( list == null ) {
            return null;
        }

        List<UserDto> list1 = new ArrayList<UserDto>( list.size() );
        for ( Users users : list ) {
            list1.add( entityToDto( users ) );
        }

        return list1;
    }

    private String userUserPropertiesFirstName(Users users) {
        if ( users == null ) {
            return null;
        }
        UserProperties userProperties = users.getUserProperties();
        if ( userProperties == null ) {
            return null;
        }
        String firstName = userProperties.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String userUserPropertiesLastName(Users users) {
        if ( users == null ) {
            return null;
        }
        UserProperties userProperties = users.getUserProperties();
        if ( userProperties == null ) {
            return null;
        }
        String lastName = userProperties.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String userUserPropertiesCustomerPhone(Users users) {
        if ( users == null ) {
            return null;
        }
        UserProperties userProperties = users.getUserProperties();
        if ( userProperties == null ) {
            return null;
        }
        String customerPhone = userProperties.getCustomerPhone();
        if ( customerPhone == null ) {
            return null;
        }
        return customerPhone;
    }

    private String userUserPropertiesShippingAddress(Users users) {
        if ( users == null ) {
            return null;
        }
        UserProperties userProperties = users.getUserProperties();
        if ( userProperties == null ) {
            return null;
        }
        String shippingAddress = userProperties.getShippingAddress();
        if ( shippingAddress == null ) {
            return null;
        }
        return shippingAddress;
    }

    private BigDecimal userUserPropertiesBalance(Users users) {
        if ( users == null ) {
            return null;
        }
        UserProperties userProperties = users.getUserProperties();
        if ( userProperties == null ) {
            return null;
        }
        BigDecimal balance = userProperties.getBalance();
        if ( balance == null ) {
            return null;
        }
        return balance;
    }

    private BigDecimal userUserPropertiesDiscount(Users users) {
        if ( users == null ) {
            return null;
        }
        UserProperties userProperties = users.getUserProperties();
        if ( userProperties == null ) {
            return null;
        }
        BigDecimal discount = userProperties.getDiscount();
        if ( discount == null ) {
            return null;
        }
        return discount;
    }

    protected UserProperties userDtoToUserProperties(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserProperties userProperties = new UserProperties();

        userProperties.setFirstName( userDto.getFirstName() );
        userProperties.setLastName( userDto.getLastName() );
        userProperties.setCustomerPhone( userDto.getCustomerPhone() );
        userProperties.setShippingAddress( userDto.getShippingAddress() );
        userProperties.setBalance( userDto.getBalance() );
        userProperties.setDiscount( userDto.getDiscount() );

        return userProperties;
    }
}

package ee.valiit.roheveeb2back.domain.company;

import ee.valiit.roheveeb2back.business.dto.CompanyDto;
import ee.valiit.roheveeb2back.business.profile.dto.CompanyInfo;
import ee.valiit.roheveeb2back.business.profile.dto.NewCompany;
import ee.valiit.roheveeb2back.domain.image.Image;
import ee.valiit.roheveeb2back.util.ImageConverter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
    @Mapping(source = "companyName", target = "name")
    @Mapping(source = "logoImageId", target = "logoImage.id")
    @Mapping(source = "locationId", target = "location.id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "companyId", target = "id")
    Company toCompany(CompanyDto companyDto);


    @Mapping(source = "companyName", target = "name")
    Company toNewCompany(NewCompany newCompany);

    @Named("ImageDataToImage")
    static Image ImageDataToImage(String image) {
        return ImageConverter.imageDataToImage(image);
    }


    @Mapping(source = "name", target = "companyName")
    @Mapping(source = "logoImage.data", target = "logoImageData")
    @Mapping(source = "location.latitude", target = "locationLatitude")
    @Mapping(source = "location.longitude", target = "locationLongitude")
    @Mapping(source = "location.postalCode", target = "locationPostalCode")
    @Mapping(source = "location.address", target = "locationAddress")
    @Mapping(source = "location.county.name", target = "locationCountyName")
    @Mapping(source = "user.password", target = "userPassword")
    @Mapping(source = "user.email", target = "userEmail")
    CompanyInfo toCompanyInfo(Company company);

}


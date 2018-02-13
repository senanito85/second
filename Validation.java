import java.util.List;
/**
 * The Validation class represents the function to check wether input values are validate or 
 * not, including "regNumber","carMake","carModel","age","minPrice","maxPrice","colours","year"
 * and "str".
 * 
 * @author Xiaofen Pan
 * @verson  
 */

public class Validation 
{
    /**
     * The method is to check if the Registration Number is validate or not.
     * @param regNumber The registration number to be looked up. 
     * @throws                Throw the exception when the registration number is not validate.
     */
    public void checkRegistrationNumber(String regNumber) throws Exception 
    {
        if (regNumber.trim().equals(""))
        {
            throw new Exception("Registration number can't be empty!");
        }
        
        if (regNumber.length() < 1 || regNumber.length() > 6)
        {
            throw new Exception("Registration Number must contain from 1 to 6 alphanumerical symbols!");
        }
        
        if (!stringRegex(regNumber))
        {
            throw new Exception("Registration Number must contain only alphanumerical symbols!");
        }
    }

    /**
     * The method is to check if the car make and model is validate or not.
     * @param carMake carModel The car make and model to be looked up. 
     * @throws               Throw the exception when the car make and model is not validate.
     */
    public void checkCarMakeAndModel(String carMake, String carModel) throws Exception 
    {
        if (carMake != null) 
        {
            if (carMake.trim().equals(""))
            {
                throw new Exception("Car make cannot be empty!");
            }
            
            if (!carMake.matches("^[a-zA-Z0-9 ]*$")) 
            {
                throw new Exception("Car Make must contain only alphanumerical symbols!");
            }
            
            if (carMake.isEmpty())
            {
                throw new Exception("Car Make can't be empty!");
            }
        }

        if (carModel != null) 
        {
            if (carModel.isEmpty()) 
            {
                throw new Exception("Car Model can't be empty!");
            }
            
                        if (!carModel.matches("^[a-zA-Z0-9 ]*$")) 
            {
                throw new Exception("Car Model must contain only alphanumerical symbols!");
            }
            
                        if (carModel.trim().equals(""))
            {
                throw new Exception("Car model can't be empty!");
            }
        }
    }

    /**
     * The method is to check if the age is validate or not.
     * @param age The car age to be looked up. 
     * @throws                Throw the exception when the car age is not validate.
     */
    public void checkAge(int age) throws Exception 
    {
        if (age < 0) 
        {
            throw new Exception("age of car must be a positive number");
        }
    }

    /**
     * The method is to check if the car min price is validate or not.
     * @param minPrice The car min price to be looked up. 
     * @throws                Throw the exception when the car min price is not validate.
     */
    public void checkMinPrice(int minPrice) throws Exception 
    {
        if (minPrice < 1) 
        {
            throw new Exception("minimum price of car must be greater than 0!");
        }
    }

    /**
     * The method is to check if the car min price and max price are validate or not.
     * @param minPrice MaxPrice The car min price and max price to be looked up. 
     * @throws                Throw the exception when the car min price and max price are not validate.
     */
    public void checkMaxPrice(int minPrice, int maxPrice) throws Exception 
    {
        if (maxPrice < minPrice) 
        {
            throw new Exception("Maximum price can't be less then the minimum price!");
        }
    }

    /**
     * The method is to check if the colours list is validate or not.
     * @param colours The colours to be looked up. 
     * @throws                Throw the exception when the car colours list is not validate.
     */
    public void checkColours(List<String> colours) throws Exception 
    {
        if (colours.isEmpty()) 
        {
            throw new Exception("Colours can't be empty!");
        }
        
        if (colours.size() > 3) 
        {
            throw new Exception("You can't select more than 3 colours!");
        }
        
        for (String colour : colours) 
        {
            checkColour(colour.trim());
        }
    }

    /**
     * The method is to check if the colour is validate or not.
     * @param colour The colour to be looked up. 
     * @throws                Throw the exception when the colouris not validate.
     */
    public void checkColour(String colour) throws Exception 
    {
        if (colour == null) 
        {
            throw new Exception("Colour name can't be empty");
        }
        
        if (!colour.matches("^[a-zA-Z ]*$")) 
        {
            throw new Exception("Colour must contain only alphanumerical symbols!");
        }
        
        if (colour.trim().equals(""))
        {
            throw new Exception("Colour can't be empty!");
        }
    }

    /**
     * The method is to check if the year is validate or not.
     * @param year The car year to be looked up. 
     * @throws                Throw the exception when the car year is not validate.
     */
    public void checkYear(int year) throws Exception 
    {
        if (year < 1900 || year > 2017) 
        {
            throw new Exception("Made Year must be from 1900 to 2017!");
        }
    }

    /**
     * Check the entry with the given car.
     * @param car One of the cars of the entry should exist,not be null.
     * @throws Exception If the car is null.
     */
    public void validateCar(Car car) throws Exception 
    {
        if (car == null) 
        {
            throw new Exception("Car can't be null!");
        }

        checkRegistrationNumber(car.getRegNumber());
        checkYear(car.getYear());
        checkColours(car.getColours());
        checkCarMakeAndModel(car.getMake(), car.getModel());
        checkMinPrice(car.getPrice());
    }

    /**
     * match the string is composite of "0-9" / "A-Z" / "a-z",
     * otherwise throw exception.
     * @param str The regex can be from A-Z,a-z,0-9
     * @return Return boolean
     */

    private boolean stringRegex(String str) 
    {
        if (str.matches("^[a-zA-Z0-9]*$")) 
        {   
            return true;
        }
        return false;
    }

}

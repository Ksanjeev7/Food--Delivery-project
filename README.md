#
![Forks](https://img.shields.io/badge/STACK%20-%238F17FF?style=flat)
 
 ![Forks](https://img.shields.io/badge/java-orange?style=flat)
 ![Forks](https://img.shields.io/badge/Servlets-red?style=flat)
 ![Forks](https://img.shields.io/badge/JDBC-blue?style=flat)
 ![Forks](https://img.shields.io/badge/MYSQL-Blue?style=flat)
 ![Forks](https://img.shields.io/badge/HTML-green?style=flat)
 ![Forks](https://img.shields.io/badge/CSS%20-8A254E?style=flat)
 ![Forks](https://img.shields.io/badge/JS%20-yellow?style=flat)

#  Food Delivery Project

## Description

```bash
This project is an online food delivery application developed using Java, JDBC, JSP, Servlet, MySQL Database, HTML, CSS, and JS. 
It provides a user-friendly interface for browsing restaurants,
viewing menus, adding items to the cart, and placing orders securely showing order history to the user.
Restaurant Admins can  add new restaurants, and menus, able to edit, and delete their restaurants, and menus.
```

**Features**:
*  User Authentication: Users can sign up and login securely using the provided credentials.Ex:(Username: Scachin, Password: Sachin@123).
*  Edit: User and Restaurant_admin's  can edit their profile's when they login
*  Browse Restaurants: Clickable images allow users to view menus of different restaurants.
*  Add to Cart: Users can add items to their cart using the "Add More" button. The cart supports updating and removing items.
*  Checkout: Users need to provide their address and select a payment mode before confirming the order.
*  OrderedItems check: Users can check what items they ordered.
*  Order History: An order information page displays all previous orders placed by the user according to the order date placed.
*  Logout: Users can log out securely using the logout button and return to the welcome page.

**Usage**:
*  Sign in using your credentials (Username: Scachin, Password: Sachin@123) or register if you are a new user.
*  Browse restaurants and click on images to view menus.
*  Add items to your cart using the "Add-to-Cart" button. You can update or remove items from the cart as needed.
*  Proceed to checkout, provide your address, and select a payment mode to confirm your order.
*  click on 'Know More' btn to check ordered Items.
*  View order history on the order information page.

# Password Reset Feature

## Overview
The password reset feature allows users who have forgotten their passwords to securely create a new one. 
This feature enhances user experience and security by providing a self-service option for account recovery.

## How It Works

1. **Initiate Reset**: On the login page, users can click on a "Forgot Password" link.

2. **Enter Email**: Users are prompted to enter their registered email address.

3. **Token Generation**: The system generates a unique, time-limited token associated with the user's account.

4. **Email Notification**: An email containing a password reset link with the token is sent to the user's registered email address.

5. **Reset Page**: Clicking the link in the email takes the user to a secure password reset page.

6. **New Password**: User enters and confirms their new password.

7. **Password Update**: Upon submission, the system verifies the token and updates the user's password.

8. **Confirmation**: The user receives a confirmation of a successful password reset.

## Security Measures

- Tokens are unique and time-limited (expiring after a set period, e.g., 1 hour).
- Tokens are single-use and invalidated after a password reset.
- Password reset links are sent only to registered email addresses.
- New passwords must meet the application's password strength requirements.
- All password reset attempts (successful or failed) are logged for security auditing.

## Implementation Details

- **Token Generation**: Utilizes Java's `UUID.randomUUID()` for creating unique tokens.
- **Email Service**: Uses JavaMail API to send password reset emails.
- **Password Encryption**: Passwords are hashed using [bcrypt] before storage.
- **Database Updates**: User passwords are updated in the database only after successful token verification.


## Usage

To use this feature in development or testing:

1. Run the application and navigate to the login page.
2. Click on "Forgot Password" and follow the prompts.
3. Check the console or configured email service for the reset link (in development environments).

## Notes

- Regularly review and update the password reset feature to maintain security standards.

## Contributing
We welcome any and all contributions! Here are some ways you can get started:
1. Report bugs: If you encounter any bugs, please let us know. Open up an issue and let us know the problem.
2. Contribute code: If you are a developer and want to contribute, follow the instructions below to get started!
3. Suggestions: If you don't want to code but have some awesome ideas, open up an issue explaining some updates or improvements you would like to see!
4. Documentation: If you see the need for some additional documentation, feel free to add some!


## Instructions
1. Fork this repository
2. Clone the forked repository
3. Add your contributions (code or documentation)
4. Commit and push
5. Wait for the pull request to be merged

***Follow me on:***
 ![Social](https://img.shields.io/twitter/follow/SanjeevSanju00)

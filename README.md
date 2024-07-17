Online Food Delivery Project

Overview:
This project is an online food delivery application developed using Java, JDBC, JSP, Servlet, MySQL Workbench, HTML, and CSS. It provides a user-friendly interface for browsing restaurants,
viewing menus, adding items to the cart, and placing orders securely.

Features:
.User Authentication: Users can sign up and log in securely using the provided credentials (Username: Scachin, Password: Sachin@123).
.Browse Restaurants: Clickable images allow users to view menus of different restaurants.
.Add to Cart: Users can add items to their cart using the "Add More" button. The cart supports updating and removing items.
.Checkout: Users need to provide their address and select a payment mode before confirming the order.
.Order History: An order information page displays all previous orders placed by the user.
.Logout: Users can log out securely using the logout button.

Usage:
.Sign in using the provided credentials (Username: Scachin, Password: Sachin@123) or register if you are a new user.
.Browse restaurants and click on images to view menus.
.Add items to your cart using the "Add More" button. You can update or remove items from the cart as needed.
.Proceed to checkout, provide your address, and select a payment mode to confirm your order.
.View order history on the order information page.

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

6. **New Password**: The user enters and confirms their new password.

7. **Password Update**: Upon submission, the system verifies the token and updates the user's password.

8. **Confirmation**: The user receives a confirmation of successful password reset.

## Security Measures

- Tokens are unique and time-limited (expiring after a set period, e.g., 1 hour).
- Tokens are single-use and invalidated after password reset.
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

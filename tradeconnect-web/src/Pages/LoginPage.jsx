import React from "react";
import styles from "./styles/LoginPage.module.css";
import LoginLogo from "../assets/shopping_login.svg";
import LoginForm from "../Components/LogInForm";
import SignUpText from "../Components/SignUpText";

function LoginPage() {
    return (
        <div className={styles.loginContainer}>
            <div className={styles.loginPageLeftContainer}>
                <img src={LoginLogo} alt="Login Logo" />
            </div>

            <div className={styles.loginPageRightContainer}>
                <div className={styles.loginForm}>
                    <LoginForm />

                    <SignUpText />
                </div>
            </div>
        </div>
    );
}

export default LoginPage;
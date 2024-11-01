import React from "react";
import styles from "./styles/LogInForm.module.css";
import { useState } from 'react';

function LoginForm() {
    const [passwordVisible, setPasswordVisible] = useState(false);

    const togglePasswordVisibility = () => {
        setPasswordVisible(!passwordVisible);
    };

    return (
        <div className={styles.loginForm}>
            <h1 className={styles.loginFormTitle}>Welcome back!</h1>
            <p className={styles.loginFormDescription}>
                Log in now to access exclusive deals, track your orders, and enjoy a personalized shopping experience.
            </p>
            <form className={styles.loginFormForm}>
                <input className={styles.loginFormInput} type="email" placeholder="Email" />
                {/* <input className={styles.loginFormInput} type="password" placeholder="Password" /> */}
                <div className={styles.passwordContainer}>
                    <input
                        className={styles.loginFormInput}
                        type={passwordVisible ? "text" : "password"}
                        placeholder="Password"
                    />
                    <button
                        type="button"
                        className={styles.togglePasswordButton}
                        onClick={togglePasswordVisibility}
                    >
                        {passwordVisible ? "Hide" : "Show"}
                    </button>
                </div>
                <button className={styles.loginFormButton} type="submit">Login</button>
            </form>
        </div>
    );
}

export default LoginForm;
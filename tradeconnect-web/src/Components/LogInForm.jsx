import React from "react";
import styles from "./styles/LogInForm.module.css";

function LoginForm() {
    return (
        <div className={styles.loginForm}>
            <h1 className={styles.loginFormTitle}>Welcome back!</h1>
            <p className={styles.loginFormDescription}>
                Log in now to access exclusive deals, track your orders, and enjoy a personalized shopping experience.
            </p>
            <form className={styles.loginFormForm}>
                <input className={styles.loginFormInput} type="email" placeholder="Email" />
                <input className={styles.loginFormInput} type="password" placeholder="Password" />
                <button className={styles.loginFormButton} type="submit">Login</button>
            </form>
        </div>
    );
}

export default LoginForm;
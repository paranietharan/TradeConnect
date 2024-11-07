import styles from './styles/SignUpForm.module.css';

function SignUpForm() {
    return (
        <div className={styles.SignUpFormContainer}>
            <div className={styles.headingtext}>Create an Account</div>
            <div className={styles.detailsText}>Enter your details below to create your account</div>

            <div className={styles.inputContainer}>
                <form>
                    <label htmlFor="name">Name</label>
                    <input type="text" id="name" name="name" placeholder="Enter your name" />

                    <label htmlFor="email">Email</label>
                    <input type="email" id="email" name="email" placeholder="Enter your email" />

                    <label htmlFor="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Enter your password" />

                    <label htmlFor="confirmPassword">Confirm Password</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" />

                    <button type="submit" className={styles.signUpButton}>Sign Up</button>
                </form>
            </div>

        </div>
    );
}

export default SignUpForm;
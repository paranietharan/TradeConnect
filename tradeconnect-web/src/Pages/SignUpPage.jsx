import React from 'react';
import styles from './styles/SignUpPage.module.css';
import TopNavigationBar from '../Components/utils/TopNavigationBar';
import SignUpLogo from '../assets/shopping_signup.svg';
import SignUpForm from '../Components/SignUpForm';

function SignUpPage() {
  return (
    <div className={styles.signUpContainer}>
      <div className={styles.topNavigationBarContainer}>
        <TopNavigationBar />
      </div>

      <div className={styles.signUpBody}>
        <div className={styles.rightSideContainer}>
          <img src={SignUpLogo} alt="Sign Up Logo"/>
        </div>
        <div className={styles.leftSideContainer}>
          <SignUpForm />
        </div>
      </div>
    </div>
  );
}

export default SignUpPage;
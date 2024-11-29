import React from 'react';
import styles from './styles/PageFooter.module.css';

export default function PageFooter() {
    return (
        <footer className={styles.footer}>
            <div className={styles.footerContainer}>
                <div className={styles.footerSection}>
                    <h4>Customer Service</h4>
                    <ul>
                        <li><a href="#">Help Center</a></li>
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">Report Abuse</a></li>
                    </ul>
                </div>
                <div className={styles.footerSection}>
                    <h4>Company Info</h4>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Careers</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                    </ul>
                </div>
                <div className={styles.footerSection}>
                    <h4>Follow Us</h4>
                    <ul className={styles.socialMedia}>
                        <li><a href="#"><i className="fab fa-facebook-f"></i> Facebook</a></li>
                        <li><a href="#"><i className="fab fa-twitter"></i> Twitter</a></li>
                        <li><a href="#"><i className="fab fa-instagram"></i> Instagram</a></li>
                    </ul>
                </div>
            </div>
            <div className={styles.footerBottom}>
                <p>&copy; 2023 TradeConnect. All rights reserved.</p>
            </div>
        </footer>
    );
}
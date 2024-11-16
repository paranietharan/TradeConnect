import React from 'react';
import styles from './styles/SalesSection.module.css';
import SalesItem from './SalesItem';

export default function SalesSection() {
    return(
        <div className={styles.SalesSectionContainer}>
            <p className={styles.SalesSectionTitle}>Today's Sales</p>
            <div className={styles.salesTimer}>
                <div className={styles.salesTimerContent}>
                    <p className={styles.salesTimerTitle}>Ends in</p>
                    <p className={styles.salesTimerTime}>02</p>
                    <p className={styles.salesTimerTime}>:</p>
                    <p className={styles.salesTimerTime}>30</p>
                    <p className={styles.salesTimerTime}>:</p>
                    <p className={styles.salesTimerTime}>20</p>
                </div>
            </div>
            <div className={styles.salesItems}>
                <SalesItem />
            </div>
        </div>
    )
}
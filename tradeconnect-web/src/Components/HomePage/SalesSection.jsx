import React, { useRef } from 'react';
import styles from './styles/SalesSection.module.css';
import SalesItem from '../SalesItem';

export default function SalesSection() {
    const scrollContainerRef = useRef(null);

    const scrollLeft = () => {
        scrollContainerRef.current.scrollBy({ left: -200, behavior: 'smooth' });
    };

    const scrollRight = () => {
        scrollContainerRef.current.scrollBy({ left: 200, behavior: 'smooth' });
    };

    return (
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
            <div className={styles.salesItemsContainer}>
                <button className={`${styles.scrollButton} ${styles.left}`} onClick={scrollLeft}>
                    &lt;
                </button>
                <div className={styles.salesItems} ref={scrollContainerRef}>
                    <SalesItem />
                    <SalesItem />
                    <SalesItem />
                    <SalesItem />
                </div>
                <button className={`${styles.scrollButton} ${styles.right}`} onClick={scrollRight}>
                    &gt;
                </button>
            </div>

            {/* Sales section buttons */}
        </div>
    );
}
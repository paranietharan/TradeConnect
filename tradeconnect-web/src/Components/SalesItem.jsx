import OfferRating from './OfferRating';
import styles from './styles/SalesItem.module.css';

export default function SalesItem() {
    return(
        <div className={styles.SalesItemContainer}>
            <div className={styles.SalesItem}>
                <div className={styles.SalesItemImage}></div>
                <div className={styles.SalesItemDetails}>
                    <img src="https://via.placeholder.com/150" alt="Product" className={styles.SalesItemImage} />
                    <p className={styles.SalesItemName}>Product Name</p>
                    <p className={styles.SalesItemNewPrice}>$50</p>
                    <p className={styles.SalesItemOldPrice}>$100</p>
                    <button className={styles.SalesItemButton}>Add to Cart</button>
                    <div className={styles.SalesItemRating}>
                        <OfferRating rating={4} />
                    </div>
                </div>
            </div>
        </div>
    )
}
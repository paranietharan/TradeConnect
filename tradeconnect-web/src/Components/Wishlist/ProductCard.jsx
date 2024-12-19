import styles from "./styles/ProductCard.module.css"

export default function ProductCard({ img, productName, price, offer }) {

    // calculate the offer price
    const OfferPrice = price - (price*(offer/100));

    return (
        <div className={styles.ProductCard}>
            <div className={styles.top}>
                <p className={styles.offer}>{offer}</p>
                <button className={styles.delButton}>
                    <i class="bi bi-trash3"></i>
                </button>
                <div className={styles.image}>
                    <img
                        src={img}
                        alt={productName}
                    />
                </div>
                <button className={styles.addToCart}>Add to cart</button>
            </div>
            <div className={styles.bottom}>
                <p>{productName}</p>
                <div className={styles.price}>
                    <p className={styles.offerPrice}>{OfferPrice}</p>
                    <p className={styles.actualPrice}>{price}</p>
                </div>
            </div>
        </div>
    )
}
import styles from './styles/OfferRating.module.css';

export default function OfferRating({ rating }) {
    const totalStars = 5;

    return (
        <div className={styles.OfferRatingContainer}>
            {[...Array(totalStars)].map((_, index) => (
                <span key={index} className={index < rating ? styles.filledStar : styles.emptyStar}>
                    ★
                </span>
            ))}
        </div>
    );
}
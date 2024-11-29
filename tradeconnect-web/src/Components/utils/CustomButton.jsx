

export default function CustomButton({ children, onClick, className }) {
    return (
        <button className={className} onClick={onClick}>
            {children}
        </button>
    );
}
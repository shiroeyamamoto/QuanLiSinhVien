import { Container } from "react-bootstrap";

const Footer = () => {
    return (
        <>
            <footer className="fixed-bottom bg-primary text-white">
                <Container>
                    <div class="mt-4 p-5">
                        <h1>Fats Company &copy; 2023</h1>
                        <p>Khoa CNTT, Đại học Mở Tp.HCM</p>
                    </div>
                </Container>
            </footer>
        </>
    )
}

export default Footer;
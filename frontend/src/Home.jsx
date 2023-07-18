import { 
    useState, 
    useEffect 
} from "react"

export default function Home() {

    const [service, setService] = useState({
        fullName: '',
        startingDate: '',
        endingDate: '',
        price: '',
        amountPaid: '',
        paymentDate: '',
        status: ''
    })
    const [services, setServices] = useState([])
    const [update, setUpdate] = useState()

    return (
      <div className="container">
        <h1>Sistema de Cadastro de Serviços</h1>
      </div>
    )

  }
  
  
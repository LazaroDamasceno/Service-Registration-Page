import { 
    useState, 
    useEffect 
} from "react"

export default function Home() {

    const [service, setService] = useState({
        fullName: '',
        startingDate: '',
        endingDate: '',
        description: '',
        price: '',
        amountPaid: '',
        paymentDate: '',
        status: ''
    })

    const [services, setServices] = useState([])

    const [update, setUpdate] = useState()

    const handleChange = (event) => {
      setService({...service, [event.target.name]:event.target.value})
    }

    return (
      <div className="container">
        <h1>Sistema de Cadastro de Serviços</h1>
        <form>
          <div className="col-6">
            <div>
              <label>Full Name: </label>
              <input 
                type="text" 
                name="fullName" 
                value={service.fullName} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>
            <div>
              <label>Starting Date: </label>
              <input 
                type="date" 
                name="startingDate" 
                value={service.startingDate} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>
            <div>
              <label>Ending Date: </label>
              <input 
                type="date" 
                name="endingDate" 
                value={service.endingDate} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>    
            <div>
              <label>Description: </label>
              <input 
                type="text" 
                name="description" 
                value={service.description} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>    
            <div>
              <label>Price: </label>
              <input 
                type="number" 
                name="price" 
                value={service.price} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>           
            <div>
              <label>Amount Paid: </label>
              <input 
                type="number" 
                name="amountPaid" 
                value={service.amountPaid} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>   
            <div>
              <label>Payment Date: </label>
              <input 
                type="date"
                name="paymentDate"
                value={service.paymentDate}
                className="form-control"
                onChange={handleChange}
              />
            </div>
          </div>
        </form>
      </div>
    )

  }
  
  
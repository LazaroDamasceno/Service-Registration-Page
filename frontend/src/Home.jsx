import { 
    useState, 
    useEffect 
} from "react"
import axios from 'axios'

export default function Home() {

    const [service, setService] = useState({
        id: '',
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

    function handleChange(event) {
      setService({ ...service, [event.target.name]: event.target.value })
    }
    
    function handleSubmit(event) {
      event.preventDefault()
      if (service.id) {
        axios.post("http://localhost:8080/services", service).then((result) => {
          setUpdate(result) 
      })}
      else {
        axios.post("http://localhost:8080/services", service).then((result) => {
          setUpdate(result) 
      })}
      clearData()
    }

    function deleteById(id) {
      axios.delete("http://localhost:8080/services/" + id).then(result => {
        setUpdate(result)
    })}

    function cancelById(id) {
      axios.put("http://localhost:8080/services/cancel/" + id).then(result => {
        setUpdate(result)
    })}

    function clearData() {
      setService({
        id: '',
        fullName: '',
        startingDate: '',
        endingDate: '',
        description: '',
        price: '',
        amountPaid: '',
        paymentDate: '',
        status: ''
      })}

    useEffect(() => {
      axios.get("http://localhost:8080/services").then(result => {
        setServices(result.data)
      })
    }, [update])

    return (
      <div className="container">
        <h1>Sistema de Cadastro de Serviços</h1>
        <form onSubmit={handleSubmit}>
          <div className="col-6">
            <div>
              <label>Full Name: </label>
              <input 
                type="text" 
                name="fullName" 
                value={service.fullName || ''} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>
            <div>
              <label>Starting Date: </label>
              <input 
                type="date" 
                name="startingDate" 
                value={service.startingDate || ''} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>
            <div>
              <label>Ending Date: </label>
              <input 
                type="date" 
                name="endingDate" 
                value={service.endingDate || ''} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>    
            <div>
              <label>Description: </label>
              <input 
                type="text" 
                name="description" 
                value={service.description || ''} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>    
            <div>
              <label>Price: </label>
              <input 
                type="number" 
                name="price" 
                value={service.price || ''} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>           
            <div>
              <label>Amount Paid: </label>
              <input 
                type="number" 
                name="amountPaid" 
                value={service.amountPaid || ''} 
                className="form-control" 
                onChange={handleChange}
              />
            </div>   
            <div>
              <label>Payment Date: </label>
              <input 
                type="date"
                name="paymentDate"
                value={service.paymentDate || ''}
                className="form-control"
                onChange={handleChange}
              />
            </div>
            <br/>
            <input type="submit"  className="btn btn-success" value="Register" />
          </div>
          </form>
          <br/>
          <hr/><hr/>
          <table className="table">
            <thead>
              <tr>
              <th scope="col">Id</th>
                <th scope="col">Full Name</th>
                <th scope="col">Starting Date</th>
                <th scope="col">Ending Date</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Amount Paid</th>
                <th scope="col">Status</th>
                <th scope="col">Options</th>
              </tr>
            </thead>
            <tbody>
                {services.map(serv => (
                  <tr key={serv.id}>
                    <td scope="row">{serv.id}</td>
                    <td scope="row">{serv.fullName}</td>
                    <td scope="row">{serv.startingDate}</td>
                    <td scope="row">{serv.endingDate}</td>
                    <td scope="row">{serv.description}</td>
                    <td scope="row">{serv.price}</td>
                    <td scope="row">{serv.amountPaid}</td>
                    <td scope="row">{serv.status}</td>
                    <td>
                      {serv.status == 'CANCELLED' && <div>
                          <button onClick={()=>deleteById(serv.id)} className="btn btn-danger">Delete</button>
                        </div>
                      }
                      <button onClick={()=>setService(serv)} className="btn btn-primary">Update</button>
                      &nbsp;&nbsp;
                      <button onClick={()=>deleteById(serv.id)} className="btn btn-danger">Delete</button>
                      &nbsp;&nbsp;
                      <button onClick={()=>cancelById(serv.id)} className="btn btn-warning">Cancel</button>
                    </td>
                  </tr>
                ))}
            </tbody>
        </table>
      </div>
    )

  }
  
  
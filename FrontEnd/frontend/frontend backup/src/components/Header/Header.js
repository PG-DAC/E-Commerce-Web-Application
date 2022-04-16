import React from 'react'

import '../Header/Header.css'

import { useState } from 'react'
import { useNavigate } from 'react-router'
import { fullWidth } from 'validator/lib/isFullWidth'

const Header = () => {

  const { firstName } = sessionStorage;
  const navigate = useNavigate()

  const logoutUser = () => {
    sessionStorage.removeItem("id");
    sessionStorage.removeItem("firstName");
    sessionStorage.removeItem("lastName");
    navigate("/homePage");
    window.location.reload(false);//if we want to refresh the page after perform specific action

  };


  const profile = () =>
  {
    navigate("/profile")
  }
  return (

    <div  className='drops' >

      <nav className="navbar navbar-expand-sm" id="Nav"style={{ 
      backgroundImage: `url("https://i.ibb.co/sQftxH9/images-1.jpg")` ,
      textDecoration:"none"
    }}>

        <a id="navbar-brand" href="/" data-mdb-toggle="tooltip" title="Home" style={{textDecoration:"none"}} className=''>
          <div className='row ' style={{textAlign:"center"}}>
            <div class='row' style={{marginLeft:"0px",color:"black",fontSize:"30px",fontWeight:"bold",textAlign:"center"}}>E-Commerce Web App</div>
           
          </div>
        </a>
        <div className="container p-0" >
          <div class="col-lg-6 col-sm-6 col-md-6 col-xl-6">
            
          </div>

          
          <div className="btn-group col-lg-1 col-sm-1 col-md-1 col-auto" id="down" >

            <button type="button" id="Actionbutton" className="btn btn-white btn-outline-danger dropdown-toggle dropdown-toggle-split border border-dark" style={{marginRight:"1000px"}}
              data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <a  id='BtnMenu' data-mdb-toggle="tooltip" data-mdb-placement="bottom" title="Menu" className='badge text-wrap p-0 mr-9' style={{textDecoration:"none"}} >Welcome {firstName}</a>

            </button>
            <i class="fas fa-cog"></i>
            
              <ul className="dropdown-menu border border-dark" id='d1' >

                <li><a className="dropdown-item"  href="/signup">Registration</a></li>
                <li><a className="dropdown-item" href="/signin">Login</a></li>
                <li><a className="dropdown-item"  onClick={logoutUser}>Logout</a></li>
                <li><a className="dropdown-item" onClick={profile}>Profile</a></li>
               
              </ul>
            
            {firstName != undefined &&
              <ul className="dropdown-menu border border-dark" id='d1'>

               
                <i class="fas fa-cog"></i>
               
               
              </ul>
            }

            {/* {firstName == undefined ?
              <ul className="dropdown-menu border border-dark">

                <li><a className="dropdown-item" href="/signup">User Registration</a></li>
                <li><a className="dropdown-item" href="/signin">User Login</a></li>
               :<li><a className="dropdown-item" onClick={logoutUser}>Logout</a></li>
                <i class="fas fa-cog"></i>
                <div class="dropdown-divider"></div>
                <li><a className="dropdown-item" href="/faq">FAQ's</a></li>
              </ul>} */}


          </div>

        </div>

      </nav>

    </div>
  )

}

export default Header

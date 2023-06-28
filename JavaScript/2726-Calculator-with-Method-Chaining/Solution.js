class Calculator {
  
  /** 
   * @param {number} value
   */
  constructor(value) {
      this.n = value;
  }

  /** 
   * @param {number} value
   * @return {Calculator}
   */
  add(value){
      return this.n += value;
  }

  /** 
   * @param {number} value
   * @return {Calculator}
   */
  subtract(value){
      return this.n -= value;
  }

  /** 
   * @param {number} value
   * @return {Calculator}
   */  
  multiply(value) {
      return this.n *= value;
  }

  /** 
   * @param {number} value
   * @return {Calculator}
   */
  divide(value) {
      return this.n = (value === 0) ? ("Division by zero is not allowed") : (this.n / value);
  }
  
  /** 
   * @param {number} value
   * @return {Calculator}
   */
  power(value) {
      return this.n = this.n ** value;
  }
    
  /** 
   * @return {number}
   */
  getResult() {
      return this.n;
  }
}
